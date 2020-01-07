package life.qbic.portal.infrastructure.view.workflowruninfolist

import com.vaadin.ui.Grid
import com.vaadin.ui.TextField

class WorkflowRunListGrid extends Grid{
    WorkflowRunListGrid() {
        super()
        TextField labelField = new TextField();
        labelField.setLabel("Label");
    }
}
    