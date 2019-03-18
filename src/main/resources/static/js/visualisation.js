"use strict";
document.onload = (function(d3, saveAs, Blob, undefined){
    // define graphcreator object
    var GraphCreator = function(svg, nodes, edges){
        var thisGraph = this;
        thisGraph.idct = 0;

        thisGraph.nodes = nodes || [];
        thisGraph.edges = edges || [];

        thisGraph.state = {
            selectedNode: null,
            selectedEdge: null,
            mouseDownNode: null,
            mouseDownLink: null,
            justDragged: false,
            justScaleTransGraph: false,
            lastKeyDown: -1,
            shiftNodeDrag: false,
            selectedText: null
        };

        // define arrow markers for graph links
        var defs = svg.append('svg:defs');
        defs.append('svg:marker')
            .attr('id', 'end-arrow')
            .attr('viewBox', '0 -5 10 10')
            .attr('refX', "32")
            .attr('markerWidth', 3.5)
            .attr('markerHeight', 3.5)
            .attr('orient', 'auto')
            .append('svg:path')
            .attr('d', 'M0,-5L10,0L0,5');

        // define arrow markers for leading arrow
        defs.append('svg:marker')
            .attr('id', 'mark-end-arrow')
            .attr('viewBox', '0 -5 10 10')
            .attr('refX', 7)
            .attr('markerWidth', 3.5)
            .attr('markerHeight', 3.5)
            .attr('orient', 'auto')
            .append('svg:path')
            .attr('d', 'M0,-5L10,0L0,5');

        thisGraph.svg = svg;
        thisGraph.svgG = svg.append("g")
            .classed(thisGraph.consts.graphClass, true);
        var svgG = thisGraph.svgG;

        // displayed when dragging between nodes
        thisGraph.dragLine = svgG.append('svg:path')
            .attr('class', 'link dragline hidden')
            .attr('d', 'M0,0L0,0')
            .style('marker-end', 'url(#mark-end-arrow)');

        // svg nodes and edges
        thisGraph.paths = svgG.append("g").selectAll("g");
        thisGraph.circles = svgG.append("g").selectAll("g");

        thisGraph.drag = d3.behavior.drag()
            .origin(function(d){
                return {x: d.x, y: d.y};
            })
            .on("drag", function(args){
                thisGraph.state.justDragged = true;
                thisGraph.dragmove.call(thisGraph, args);
            })
            .on("dragend", function() {
                // todo check if edge-mode is selected
            });

        // listen for dragging
        var dragSvg = d3.behavior.zoom()
            .on("zoom", function(){
                if (d3.event.sourceEvent.shiftKey){
                    // TODO  the internal d3 state is still changing
                    return false;
                } else{
                    thisGraph.zoomed.call(thisGraph);
                }
                return true;
            })
            .on("zoomstart", function(){
                var ael = d3.select("#" + thisGraph.consts.activeEditId).node();
                if (ael){
                    ael.blur();
                }
                if (!d3.event.sourceEvent.shiftKey) d3.select('body').style("cursor", "move");
            })
            .on("zoomend", function(){
                d3.select('body').style("cursor", "auto");
            });

        svg.call(dragSvg).on("dblclick.zoom", null);

        // listen for resize
        window.onresize = function(){thisGraph.updateWindow(svg);};
    };

    GraphCreator.prototype.consts =  {
        selectedClass: "selected",
        connectClass: "connect-node",
        circleGClass: "conceptG",
        graphClass: "graph",
        activeEditId: "active-editing",
        BACKSPACE_KEY: 8,
        DELETE_KEY: 46,
        ENTER_KEY: 13,
        nodeRadius: 50
    };

    /* PROTOTYPE FUNCTIONS */

    GraphCreator.prototype.dragmove = function(d) {
        var thisGraph = this;
        if (thisGraph.state.shiftNodeDrag){
            thisGraph.dragLine.attr('d', 'M' + d.x + ',' + d.y + 'L' + d3.mouse(thisGraph.svgG.node())[0] + ',' + d3.mouse(this.svgG.node())[1]);
        } else{
            d.x += d3.event.dx;
            d.y +=  d3.event.dy;
            thisGraph.updateGraph();
            $.ajax({
                type: 'POST',
                url: '/updateNodePosition',
                headers: {"X-CSRF-TOKEN": $("input[name='_csrf']").val()},
                dataType: 'json',
                contentType: "application/json; charset=utf-8",
                data: JSON.stringify(d)
            });
        }
    };

    /* insert svg line breaks: taken from http://stackoverflow.com/questions/13241475/how-do-i-include-newlines-in-labels-in-d3-charts */
    GraphCreator.prototype.insertTitleLinebreaks = function (gEl, title) {
        var words = title.split(/\s+/g),
            nwords = words.length;
        var el = gEl.append("text")
            .attr("text-anchor","middle")
            .attr("dy", "-" + (nwords-1)*7.5);

        for (var i = 0; i < words.length; i++) {
            var tspan = el.append('tspan').text(words[i]);
            if (i > 0)
                tspan.attr('x', 0).attr('dy', '15');
        }
    };

    // mousedown on node
    GraphCreator.prototype.circleMouseDown = function(d3node, d){
        var thisGraph = this,
            state = thisGraph.state;
        d3.event.stopPropagation();
        state.mouseDownNode = d;
    };

    // mouseup on nodes
    GraphCreator.prototype.circleMouseUp = function(d3node, d){
        var thisGraph = this,
            state = thisGraph.state,
            consts = thisGraph.consts;
        // reset the states
        state.shiftNodeDrag = false;
        d3node.classed(consts.connectClass, false);

        var mouseDownNode = state.mouseDownNode;

        if (!mouseDownNode) return;

        thisGraph.dragLine.classed("hidden", true);

        if (mouseDownNode !== d){
            // we're in a different node: create new edge for mousedown edge and add to graph
            var newEdge = {source: mouseDownNode, target: d};
            var filtRes = thisGraph.paths.filter(function(d){
                if (d.source === newEdge.target && d.target === newEdge.source){
                    thisGraph.edges.splice(thisGraph.edges.indexOf(d), 1);
                }
                return d.source === newEdge.source && d.target === newEdge.target;
            });
            if (!filtRes[0].length){
                thisGraph.edges.push(newEdge);
                thisGraph.updateGraph();
            }
        } else{
            // we're in the same node
            if (state.justDragged) {
                // dragged, not clicked
                state.justDragged = false;
            }
        }
        state.mouseDownNode = null;

    }; // end of circles mouseup

    // call to propagate changes to graph
    GraphCreator.prototype.updateGraph = function(){

        var thisGraph = this,
            consts = thisGraph.consts,
            state = thisGraph.state;

        thisGraph.paths = thisGraph.paths.data(thisGraph.edges, function(d){
            return String(d.source.id) + "+" + String(d.target.id);
        });
        var paths = thisGraph.paths;
        // update existing paths
        paths.style('marker-end', 'url(#end-arrow)')
            .classed(consts.selectedClass, function(d){
                return d === state.selectedEdge;
            })
            .attr("d", function(d){
                return "M" + d.source.x + "," + d.source.y + "L" + d.target.x + "," + d.target.y;
            })
            .attr("stroke-width", function(d) { return (d.edgeWeight); })
        ;

        // add new paths
        paths.enter()
            .append("path")
            .style('marker-end','url(#end-arrow)')
            .classed("link", true)
            .attr("d", function(d){
                return "M" + d.source.x + "," + d.source.y + "L" + d.target.x + "," + d.target.y;
            })
            .attr("stroke-width", function(d) { return (d.edgeWeight); })
        ;



        // remove old links
        paths.exit().remove();

        // update existing nodes
        thisGraph.circles = thisGraph.circles.data(thisGraph.nodes, function(d){ return d.id;});
        thisGraph.circles.attr("transform", function(d){return "translate(" + d.x + "," + d.y + ")";});

        // add new nodes
        var newGs= thisGraph.circles.enter()
            .append("g");

        newGs.classed(consts.circleGClass, true)
            .attr("transform", function(d){return "translate(" + d.x + "," + d.y + ")";})
            .on("mouseover", function(d){
                if (state.shiftNodeDrag){
                    d3.select(this).classed(consts.connectClass, true);
                }
            })
            .on("mouseout", function(d){
                d3.select(this).classed(consts.connectClass, false);
            })
            .on("mousedown", function(d){
                thisGraph.circleMouseDown.call(thisGraph, d3.select(this), d);
            })
            .on("mouseup", function(d){
                thisGraph.circleMouseUp.call(thisGraph, d3.select(this), d);
            })
            .call(thisGraph.drag);

        newGs.append("circle")
            .attr("r", String(consts.nodeRadius));

        newGs.each(function(d){
            thisGraph.insertTitleLinebreaks(d3.select(this), d.title);
        });

        // remove old nodes
        thisGraph.circles.exit().remove();
    };

    GraphCreator.prototype.zoomed = function(){
        this.state.justScaleTransGraph = true;
        d3.select("." + this.consts.graphClass)
            .attr("transform", "translate(" + d3.event.translate + ") scale(" + d3.event.scale + ")");
    };

    GraphCreator.prototype.updateWindow = function(svg){
        var docEl = document.documentElement,
            bodyEl = document.getElementsByTagName('body')[0];
        var x = window.innerWidth || docEl.clientWidth || bodyEl.clientWidth;
        var y = window.innerHeight|| docEl.clientHeight|| bodyEl.clientHeight;
        svg.attr("width", x).attr("height", y);
    };

    function findIndexById(array, value) {
        for(var i = 0; i < array.length; i += 1) {
            if(array[i].id === value) {
                return i;
            }
        }
        return -1;
    }

    function getNeighbours(nodeIndex, edges) {
        var neighbours = new Array();
        for(var i = 0; i< edges.length; i++){
            var edge = edges[i];
            var sourceNodeIndex = edge.source.id;
            var destinationNodeIndex = edge.target.id;
            if(sourceNodeIndex === nodeIndex){
                neighbours.push(destinationNodeIndex)
            }
        }
        return neighbours;
    }

    // Adds vertices and edges to visualisation by performing Depth First Search
    // Adds children nodes to the right of the parent nodes
    function DFS(nodeIndex, graphNodes, graphEdges, nodeIsVisited, x, y){
        var neighbours = getNeighbours(nodeIndex, graphEdges);

        for(var i = 0; i < neighbours.length; i++) {

            var neighbourIndex = neighbours[i];
            if (nodeIsVisited[neighbourIndex] === false) {
                nodeIsVisited[neighbourIndex] = true;
                graphNodes[neighbourIndex].x = x+400;
                graphNodes[neighbourIndex].y = y + (i - Math.floor(neighbours.length/2))*100;
                DFS(neighbourIndex, graphNodes, graphEdges, nodeIsVisited, x + 200, y + (i - Math.floor(neighbours.length/2))*200);
            }
            else{
                graphNodes[nodeIndex].y -= 200;
            }
        }
    }

    /**** MAIN ****/

    // warn the user when leaving
    window.onbeforeunload = function(){
        return "Make sure to save your graph locally before leaving :-)";
    };

    var docEl = document.documentElement,
        bodyEl = document.getElementsByTagName('body')[0];

    var width = window.innerWidth || docEl.clientWidth || bodyEl.clientWidth,
        height =  window.innerHeight|| docEl.clientHeight|| bodyEl.clientHeight;

    function compareBasedOnIndex(a,b){
        if(a.id < b.id)
            return -1;
        return 1;
    }

    // Insert all nodes into graphNodes, node with id k will be at position k in the array.
    // This property must be preserved.
    function constructNodesForGraph(dataNodes){
        var x = 600, y = 400;
        // Sort nodes based on index
        dataNodes.sort(compareBasedOnIndex);
        var nodes = [];
        for(var i = 0; i < dataNodes.length; i++){
            var node = dataNodes[i];
            if(node.x != null && node.y != null){
                x = node.x;
                y = node.y;
            }
            nodes.push({
                title: node.name,
                id: node.id,
                x: x,
                y: y
            });
            x += 200;
        }
        return nodes;
    }

    function constructEdgesForGraph(dataEdges, graphNodes){
        var edges = [];
        for(var i = 0; i < dataEdges.length; i++){
            var edge = dataEdges[i];
            var sourceNodeIndex = edge.originIndex;
            var destinationNodeIndex = edge.destinationIndex;
            var weight = edge.weight;
            edges.push({
                source: graphNodes[sourceNodeIndex],
                target: graphNodes[destinationNodeIndex],
                edgeWeight: weight
            })
        }
        return edges;
    }

    // This function returns an arbitrary node that has no incoming edges. If no such node exists, an arbitrary node will
    // be returned.
    function getRoot(nodes,edges){
        var isRoot = new Array(nodes.length);
        isRoot.fill(true);
        for(var i=0; i<edges.length; i++){
            var edge = edges[i];
            var destinationNodeIndex = edge.destinationIndex;
            isRoot[destinationNodeIndex] = false;
        }

        for(var i=0;i<nodes.length;i++){
            if(isRoot[nodes[i]])
                return i;
        }
        return 0;
    }

    function modifyNodesCoordinatesForVisualisation(graphNodes, root, graphEdges){
        var isVisited = new Array(graphNodes.length);
        isVisited.fill(false);
        var x = 600, y = 400;
        graphNodes[root].x = x;
        graphNodes[root].y = y;
        isVisited[root] = true;
        DFS(root, graphNodes, graphEdges, isVisited, x, y);
    }

    function nodesHaveCoordinates(nodes){
        return nodes[0].x != null;
    }
    fetch("/data").then(function (value) { return value.json()}).then(function (data) {
        var dataNodes = data.vertices;
        var dataEdges = data.edgesList;
        var graphNodes = constructNodesForGraph(dataNodes);
        var graphEdges = constructEdgesForGraph(dataEdges,graphNodes);
        var root = getRoot(dataNodes,dataEdges);
        if(!nodesHaveCoordinates(dataNodes)){
            modifyNodesCoordinatesForVisualisation(graphNodes, root, graphEdges);
        }
        /** MAIN SVG **/
        var svg = d3.select("body").append("svg")
            .attr("width", width)
            .attr("height", height);
        var graph = new GraphCreator(svg, graphNodes, graphEdges);
        graph.updateGraph();
        $.ajax({
            type: 'POST',
            url: '/storeGraphState',
            headers: {"X-CSRF-TOKEN": $("input[name='_csrf']").val()},
            dataType: 'json',
            contentType: "application/json; charset=utf-8",
            data: JSON.stringify(graphNodes)
        });
    });

})(window.d3, window.saveAs, window.Blob);


