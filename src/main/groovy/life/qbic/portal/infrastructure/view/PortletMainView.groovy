package life.qbic.portal.infrastructure.view

import com.google.gwt.user.client.ui.ListBox
import com.vaadin.ui.Grid
import com.vaadin.ui.Layout
import com.vaadin.ui.ListSelect
import com.vaadin.ui.TextField
import com.vaadin.ui.VerticalLayout
import life.qbic.portal.domain.listworkflowruns.WorkflowRun
import life.qbic.portal.infrastructure.services.workflowtracking.Dummydata
import life.qbic.portal.infrastructure.view.workflowruninfolist.WorkflowRunInfoListViewModelObserver
import life.qbic.portal.infrastructure.view.workflowruninfolist.WorkflowRunListGrid


class PortletMainView extends VerticalLayout implements WorkflowRunInfoListViewModelObserver, Layout {


    PortletMainView() {

        super()
        createContent()

    }

    private createContent() {

        TextField labelField = new TextField()
        labelField.setValue("Value")
        this.addComponent(labelField)
        List dummydata = Dummydata.datagen()

        List namelist = []
        for (item in dummydata){
            namelist.add(item.getRunName())
        }

        ListSelect<String> select = new ListSelect<>("The List")
        select.setItems(namelist)
        select.setRows(5)
        this.addComponent(select)

        Grid grid = WorkflowRunListGrid.gridmaker(dummydata)
        this.addComponent(grid)

    }

}




