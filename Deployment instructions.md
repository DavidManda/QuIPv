## Deployment instructions
1. Push changes to https://github.com/DavidManda/QuIPv.git
2. ssh into 132.145.138.41
3. change directory to ~/QuIPv
4. `git pull`
5. `mvn package`
6. `tmux a -t 0`
7. Stop ongoing process
8. Restart app : `java -jar QuIPv/target/app-0.0.1-SNAPSHOT.jar`
