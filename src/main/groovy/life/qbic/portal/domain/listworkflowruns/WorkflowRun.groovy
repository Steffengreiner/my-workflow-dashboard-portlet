package life.qbic.portal.domain.listworkflowruns

// Define WorkflowRun Class with relevant attributes to the user

class WorkflowRun {

    String runName;
    String runningTaskName;
    Date startTime;
    WorkflowRunStatus currentRunStatus;
    int submittedCount;
    int runningCount;
    int completedCount;
    int failedCount;

    {
        this.runName = runName;
        this.runningTaskName = runningTaskName;
        this.startTime = startTime;
        this.currentRunStatus = currentRunStatus;
        this.submittedCount =  submittedCount;
        this.runningCount = runningCount;
        this.completedCount = completedCount;
        this.failedCount = failedCount;
    }

}
