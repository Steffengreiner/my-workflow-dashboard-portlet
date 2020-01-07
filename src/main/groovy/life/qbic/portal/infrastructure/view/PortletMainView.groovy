package life.qbic.portal.infrastructure.view

import com.vaadin.server.ThemeResource
import com.vaadin.ui.Button
import com.vaadin.ui.Grid
import com.vaadin.ui.Image
import com.vaadin.ui.Layout
import com.vaadin.ui.TextField
import com.vaadin.ui.VerticalLayout
import com.vaadin.ui.renderers.ImageRenderer
import life.qbic.portal.domain.listworkflowruns.WorkflowRun
import life.qbic.portal.infrastructure.services.workflowtracking.WorkflowRunService
import life.qbic.portal.infrastructure.view.workflowruninfolist.WorkflowRunInfoListViewModelObserver
import life.qbic.portal.infrastructure.view.workflowruninfolist.WorkflowRunListGrid


class PortletMainView extends VerticalLayout implements WorkflowRunInfoListViewModelObserver, Layout {

    PortletMainView() {
        super()
        createContent()

    }

    private createContent() {

        WorkflowRunListGrid runListGrid = new WorkflowRunListGrid()
        this.addComponents(runListGrid);
    }

}




