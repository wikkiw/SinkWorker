/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.wikkiw.sinkworker;

import cz.wikkiw.fitnessfunctions.objects.Individual;
import cz.wikkiw.sink.Sink;
import cz.wikkiw.sink.SinkKeysEnum;
import java.util.List;
import java.util.TreeMap;

/**
 *
 * @author adam
 */
public class Worker {

    public static double[] getBestValues(Sink... sinks){
    
        int sinksCount = sinks.length;
        double[] retArray = new double[sinksCount];
        
        for(int i=0;i<sinksCount;i++){
            
            retArray[i] = getBest(sinks[i].getRecordList());
            
        }
        
        return retArray;
        
    }
    
    /**
     * 
     * @param list
     * @return 
     */
    private static double getBest(List<TreeMap<SinkKeysEnum, Object>> list){
        
        double min = Double.MAX_VALUE;
        double value;
        
        for(TreeMap tm : list){
            
            value = ((Individual) tm.get(SinkKeysEnum.INDIVIDUAL)).getFitness();
            
            if(value < min){
                min = value;
            }
            
        }
        
        return min;
        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
