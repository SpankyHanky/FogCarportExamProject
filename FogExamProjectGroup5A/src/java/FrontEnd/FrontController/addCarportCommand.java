/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FrontEnd.FrontController;

import Data.Backend.DBFacadeImpl;
import Data.BusinessLogic.Carport;
import Data.BusinessLogic.CarportHR;
import Data.BusinessLogic.CarportDUR;
import Data.BusinessLogic.Shed;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Kornh
 */
public class addCarportCommand implements Command{
       private String next;
       private Controller ctr;
    public addCarportCommand(String jsp) {
        next  = jsp;
    }

     
 @Override
    public String execute(HttpServletRequest request) throws CommandException {
       
        DBFacadeImpl facade;
        try {
            facade = new DBFacadeImpl();
        } catch (Exception ex) {
            Logger.getLogger(carportOrderCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
                
        //Width
        setAttribute("width", 800.0, request);
        setAttribute("length", 800.0, request);
        setAttribute("height", 400.0, request);
        setAttribute("shedWidth", 0.0, request);
        setAttribute("shedLength", 0.0, request);
        setIntAttribute("angle", 0.0, request);
        
        
        double width = 0;
        double length = 0;
        double shedWidth = 0;
        double shedLength = 0;
        int angle = 0;
        double price = 0;
        
        try{
        String w = (String) request.getParameter("width");
        String l = (String) request.getParameter("length");
        String sw = (String) request.getParameter("shedWidth");
        String sl = (String) request.getParameter("shedLength");
        String a = (String) request.getParameter("angle");
        
        width = Double.parseDouble(w);
        length = Double.parseDouble(l);
        shedWidth = Double.parseDouble(sw);
        shedLength = Double.parseDouble(sl);
        angle = Integer.parseInt(a);
        
        }
        
        catch(NumberFormatException Ex){
            return "error.jsp";
        }
         
        

       
        Shed sh = null;
        try{
            if(shedWidth == 0 || shedLength == 0){
            }
            else{
            sh = new Shed(shedWidth,shedLength);    
            }
        }    
        catch(IllegalArgumentException ex){
            return "error.jsp";
        }  
        try{
        if(angle > 0){

            CarportHR carportHR = new CarportHR(width,length,sh,angle);
//            price = ctr.getPriceHR(carportHR);
        }
        else{
            CarportDUR carportDUR = new CarportDUR(width,length,sh);
//            price = ctr.getPriceDUR(carportDUR);
        }    
        }
        catch(IllegalArgumentException Ex){
            return "error.jsp";
        }
//        
//        
//   
//        double width = 0;
//        double length = 0;
//        double shedWidth = 0;
//        double shedLength = 0;
//        double height = 0;
//        int strokeWidth = 5;
//        
//        try{
//        String w = (String) request.getParameter("width");
//        String l = (String) request.getParameter("length");
//        String h = (String) request.getParameter("height");
//        String sw = (String) request.getParameter("shedWidth");
//        String sl = (String) request.getParameter("shedLength");
//        
//        
//     
//        
//        width = Double.parseDouble(w);
//        length = Double.parseDouble(l);
//        shedWidth = Double.parseDouble(sw);
//        shedLength = Double.parseDouble(sl);
//        height = Double.parseDouble(h);
//        
//        
//        
//        }
//        catch(NullPointerException Ex){
//            return "error.jsp";
//        }
        
 
        {
        return next;
        }

    }





    private void setAttribute(String name, Object defaultValue, HttpServletRequest request)
    {
        String strVal = request.getParameter(name);
 
        try
        {
            request.setAttribute(name, Double.parseDouble(strVal));
        }
        catch(NumberFormatException ex)
        {
            request.setAttribute(name, defaultValue);
        }
    }    
    private void setIntAttribute(String name, Object defaultValue, HttpServletRequest request)
    {
        String strVal = request.getParameter(name);
 
        try
        {
            request.setAttribute(name, Integer.parseInt(strVal));
        }
        catch(NumberFormatException ex)
        {
            request.setAttribute(name, defaultValue);
        }
    }    
    
    
}