package com.mycompany.testproject1;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label.*;
import com.vaadin.ui.*;
import com.vaadin.ui.VerticalLayout;

import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;

import com.vaadin.data.util.FilesystemContainer;
import com.vaadin.shared.ui.label.ContentMode;
import java.io.File;
import java.util.Set;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Form;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
/**
 * 
 *
 */

@Theme("mytheme")
@Widgetset("com.mycompany.testproject1.MyAppWidgetset")
public class MyUI extends UI {

    FilesystemContainer docs = new FilesystemContainer(new File("/Macintosh HD/Users"));
    String[] doc = {"1","2"};
    ComboBox docList = new ComboBox("Here we go");
   // docList.setInvalidFa();
    //docList.setNullSelection(false);
    
    
    //docList.add(doc);
    Label docView = new Label("WHAT UP");
    
    @Override
    protected void init(VaadinRequest vaadinRequest) {
       docList.setInvalidAllowed(false);
       docList.setNullSelectionAllowed(false);
       setComboBoxNames(docList);
        HorizontalSplitPanel split;
        split = new HorizontalSplitPanel();
        
        //setContent(split);
      
       //split.addComponent(docView);
       
       VerticalSplitPanel splitV;
        splitV = new VerticalSplitPanel();
        splitV.addComponent(docList);
       splitV.addComponent(docView);
       
       split.addComponent(splitV);
        split.addComponent(docView);
       docList.addValueChangeListener(new ValueChangeListener() {   
            @Override
            public void valueChange(Property.ValueChangeEvent event) {
                docView.setValue((String) docList.getValue());
                System.out.print("yo");
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
       });

    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
    
    public void setComboBoxNames(ComboBox cb){
        String[] groupNames = {"a", "b", "c"};
        
        for (String name:groupNames) {
            
            cb.addItem(name);
        }
        cb.setValue(groupNames[0]);
            
    }
}




/*
@Theme("mytheme")
@Widgetset("com.mycompany.testproject1.MyAppWidgetset")
public class MyUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        final VerticalLayout layout = new VerticalLayout();
        layout.setMargin(true);
        setContent(layout);

        Button button = new Button("Click Me");
        button.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                layout.addComponent(new Label("Thank you for clicking"));
            }
        });
        
        Button btn2 = new Button("Click again");
        layout.addComponent(btn2);
        layout.addComponent(button);

    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}

*/


