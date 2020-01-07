package life.qbic.portal.infrastructure.view.workflowruninfolist

import com.vaadin.server.ThemeResource
import com.vaadin.ui.Button
import com.vaadin.ui.Grid
import com.vaadin.ui.Image
import com.vaadin.ui.TextField
import com.vaadin.ui.VerticalLayout
import com.vaadin.ui.renderers.ImageRenderer
import life.qbic.portal.domain.listworkflowruns.WorkflowRun
import life.qbic.portal.infrastructure.services.workflowtracking.WorkflowRunService

import javax.management.Notification

class WorkflowRunInfoListView extends VerticalLayout implements WorkflowRunInfoListViewModelObserver {

    private def viewModel
    private WorkflowRunService service = WorkflowRunService.getInstance();

    WorkflowRunInfoListView(WorkflowRunInfoListViewModel viewModel) {
        super()
        this.viewModel = viewModel
        this.createContent()
    }

    private def createContent() {


    }
}
