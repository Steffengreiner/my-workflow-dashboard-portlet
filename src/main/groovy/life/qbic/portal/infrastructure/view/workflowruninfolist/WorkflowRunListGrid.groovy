package life.qbic.portal.infrastructure.view.workflowruninfolist

import com.vaadin.ui.Grid
import life.qbic.portal.domain.listworkflowruns.WorkflowRun
import life.qbic.portal.domain.listworkflowruns.WorkflowRunStatus
import life.qbic.portal.infrastructure.services.workflowtracking.Dummydata

class WorkflowRunListGrid  {

    static def gridmaker(List dummydata) {

        Grid grid = new Grid()
        grid.setItems(dummydata)


        grid.addColumn(WorkflowRun.&getRunName).setCaption("Run Name").setId("Run Name")
        /*
        grid.addColumn(WorkflowRun.&getCurrentRunStatus).setCaption("Status").setId("Status")
        grid.addColumn(WorkflowRun.&getStartTime).setCaption("Start Time").setId("Start Time")
        grid.addColumn(WorkflowRun.&getCompletedCount).setCaption("Completed Count")
                .setId("Completed Count")
        grid.addColumn(WorkflowRun.&getRunningCount).setCaption("Running Count").setId("Running Count")
        grid.addColumn(WorkflowRun.&getSubmittedCount).setCaption("Submitted Count")
                .setId("Submitted Count")
        grid.addColumn(WorkflowRun.&getFailedCount).setCaption("Failed Count").setId("Failed Count")

          grid.addComponentColumn({ w ->

            Image image = new Image("", new ThemeResource("img/" + w.getCurrentRunStatus() + ".png"));

            image.setWidth("100px");
            image.setHeight("100px");
            return image;
        }).setCaption("StatusIcon");

        grid.getColumn("StatusIcon").setRenderer(new ImageRenderer());

            grid.addComponentColumn({ w ->
            Button button = new Button("Click me!");
            Notification.show("Clicked: " + WorkflowRun.toString())
            return button;

        })
         */
        return grid
    }

}