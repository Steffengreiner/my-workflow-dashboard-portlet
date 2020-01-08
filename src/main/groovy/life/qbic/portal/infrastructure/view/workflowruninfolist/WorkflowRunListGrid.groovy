package life.qbic.portal.infrastructure.view.workflowruninfolist

import com.vaadin.ui.Grid
import life.qbic.portal.domain.listworkflowruns.Person
import life.qbic.portal.domain.listworkflowruns.WorkflowRun
import life.qbic.portal.domain.listworkflowruns.WorkflowRunStatus
import life.qbic.portal.infrastructure.services.workflowtracking.Dummydata

class WorkflowRunListGrid  {


    WorkflowRunListGrid(){


    }

    static def gridmaker(List dummydata)
    {

        List<Person> dummy = Arrays.asList(
                new Person("Nicolaus Copernicus", 1543, 7),
                new Person("Galileo Galilei"  , 1543, 7),
                new Person("Johannes Kepler", 1543, 7));

        Grid<Person> grid = new Grid<>()
        grid.setItems(dummy);
        grid.addColumn(Person.&getRunName).setCaption("Name");
        grid.addColumn(Person.&getBirthdate).setCaption("Year of birth");

/*
        HashMap<String, WorkflowRun> WorkflowRunMap = new HashMap<String, WorkflowRun>();
        for (WorkflowRun workflowRun : dummydata) {
            WorkflowRunMap.put(workflowRun.getRunName(), workflowRun);
        }
        WorkflowRun testobject = dummydata[0]
        grid.addColumn(testobject.getRunName())
       // grid.setItems(WorkflowRunMap)
        //grid.addColumn(WorkflowRun.&getRunName).setId("Run Name").setCaption("Name")

        /*
        grid.addColumn(WorkflowRun.&getCurrentRunStatu s).setCaption("Status").setId("Status")
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
    static def addColumn(Grid grid, Object gridtype, Object column)
    {
        String columnname = column.toString()
        grid.addColumn(gridtype.&getClass(column).setCaption("Run Name").setId("Run Name"))
    }

}