package life.qbic.portal.infrastructure.view

import life.qbic.portal.domain.listworkflowruns.WorkflowRun
import life.qbic.portal.infrastructure.services.workflowtracking.WorkflowRunService;

import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Image;
import com.vaadin.ui.renderers.ImageRenderer;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import javax.management.Notification
import javax.servlet.annotation.WebServlet;
/**
 * This UI is the application entry point. A UI may either represent a browser window (or tab) or
 * some part of a html page where a Vaadin application is embedded.
 * <p>
 **/

@Theme("mytheme")
class WorkflowUI extends UI {

    private WorkflowRunService service = WorkflowRunService.getInstance();

    @Override
    protected void init(VaadinRequest vaadinRequest) {

        //Create Basic Layout

        final VerticalLayout layout = new VerticalLayout();

        //Get Data from Service Class

        List<WorkflowRun> WorkflowRuns = service.findAll();

        //Generate Grid

        createGrid(layout, WorkflowRuns);


    }

    private Grid createGrid(VerticalLayout layout, List<WorkflowRun> workflowruns) {

        // Generate Basic Grid

        Grid<WorkflowRun> grid = new Grid<>();
        grid.setItems(workflowruns);
        layout.addComponents(grid);
        setContent(layout);

        // Set Grid Specifics such as width and selection Mode

        grid.setSelectionMode(Grid.SelectionMode.MULTI);
        grid.setWidth(100, Unit.PERCENTAGE);


        // Add Elements Columnwise to Grid

        grid.addColumn(WorkflowRun.&getRunName).setCaption("Run Name").setId("Run Name");
        grid.addColumn(WorkflowRun.&getCurrentRunStatus).setCaption("Status").setId("Status");
        grid.addColumn(WorkflowRun.&getStartTime).setCaption("Start Time").setId("Start Time");

        // Add Statusicons via Images stored in Theme to Componentcolumn

        grid.addComponentColumn({ w ->

            Image image = new Image("", new ThemeResource("img/" + w.getCurrentRunStatus() + ".png"));

            image.setWidth("100px");
            image.setHeight("100px");
            return image;
        }).setCaption("StatusIcon");

        grid.getColumn("StatusIcon").setRenderer(new ImageRenderer());

        // Add Individual Counts as Columns to Grid

        grid.addColumn(WorkflowRun.&getCompletedCount).setCaption("Completed Count")
                .setId("Completed Count");
        grid.addColumn(WorkflowRun.&getRunningCount).setCaption("Running Count").setId("Running Count");
        grid.addColumn(WorkflowRun.&getSubmittedCount).setCaption("Submitted Count")
                .setId("Submitted Count");
        grid.addColumn(WorkflowRun.&getFailedCount).setCaption("Failed Count").setId("Failed Count");

        // Basic Component Column to change into stacked Bar Chart

        grid.addComponentColumn({ w ->
            Button button = new Button("Click me!");
            Notification.show("Clicked: " + WorkflowRun.toString())
            return button;

        })
    }

    // Vaadin Specific Servlet Stuff
/*
    @WebServlet(urlPatterns = "/*", name = "WorkflowUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = WorkflowUI, productionMode = false)
    static class WorkflowUIServlet extends VaadinServlet {

    } */
}