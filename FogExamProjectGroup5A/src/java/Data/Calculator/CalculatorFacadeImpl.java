
package Data.Calculator;

import Data.BusinessLogic.CarportHR;
import Data.BusinessLogic.Part;
import Data.BusinessLogic.PartList;
import Data.BusinessLogic.PartListLine;
import java.util.ArrayList;

/**
 *Holds the CalculatorFacadeImpl that implements our calculatorFacade interface.
 * 
 * 
 * 
 * @author Kasper
 */
public class CalculatorFacadeImpl implements CalculatorFacade {
    private CarportCalculator cc;

    public CalculatorFacadeImpl(CarportCalculator cc) {
        this.cc = cc;
    }
    
    public CalculatorFacadeImpl() throws Exception {
        this.cc = new CarportCalculator();
    }
    
    
    @Override
    public PartList calculateHRNoShed(ArrayList<Part> list, CarportHR cp) {
        return cc.calculateHRNoShed(list, cp);
    }

    @Override
    public PartList calculateHRWithShed(ArrayList<Part> list, CarportHR cp) {
       return cc.calculateHRWittShed(list, cp);
    }

    @Override
    public PartList calculateDURNoShed(ArrayList<Part> list, CarportHR cp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PartList calculateDURWithShed(ArrayList<Part> list, CarportHR cp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
