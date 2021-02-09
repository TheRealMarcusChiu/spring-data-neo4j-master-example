Updated: Feb 2021

# Setup Local Environment For Development

### Prerequisite
- install and run Neo4j database
- install `IntelliJ 2020.3+`, `Java 11`, `git`, `maven` via <b>Dev Shell</b>

### Cloning Project
- setup git remote repository and stuff

### Setup `fabric-envoy` Project
- import `code-styles.xml`
- setup `spring-boot-dev.properties`
- setup Mermaid Preview
- setup test email with your company provided email address
- sort by file type on project pane

### Running `fabric-envoy` Project
via command line:
- `mvn spring-boot:run`

via IntelliJ:
- right click `MainApplication.java` and click `Run`
    
# Steps Working on a New Feature or Bug Fix
- Make sure there is a JIRA ticket associated with the task
- Go to our BitBucket repository and create a branch with the following name:
  - `EDGFABRIC-{jira-ticket-number here}-{brief-description-of-task-here}`
  - for example:
  - `EDGFABRIC-9999-fixing-readme`
- Now that the remote branch is created, you want to pull this branch to your local environment. So in your local environment at the root of this project execute the following command:
  - `git fetch` # this fetches stuff from remote-repo to local-repo
  - next you switch to branch (this branch is where you do all your development work)
  - `git checkout {branch-name-here}`
  - for example:
  - `git checkout feature/EDGFABRIC-9999-fixing-readme`

# Steps Before Commiting to Remote Branch
Once you have finished working on your local branch and are ready to `commit` and `push` to remote repository
- Make sure local build passes
  - <code>mvn clean verify -P integration-test</code>
  - NOTE: we have temporarily disabled Integration Tests for reasons. It is best to run the entire test suite manually by right clicking the `src/test/java/com.*` package
- Your commit message should have the following syntax:
  - `EDGFABRIC-{jira-ticket-number here} rest of the commit message here`
  - for example:
  - `EDGFABRIC-9999 added README.md and modified documentation`
- You could make your commit message via:
  - `git commit -am "EDGFABRIC-9999 added README.md and modified documentation"`
- If you want to undo a local commit, execute the following command:
  - `git reset --soft HEAD~1`
  - However, do this only if you haven't pushed that commit to remote repository, otherwise there will be an inconsistency between local and remote