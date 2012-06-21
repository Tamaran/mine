/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tamaran
 */
public class ClusterAnalysis {

    public Cluster perform(List<DataPoint> data, DistFunc distFunc) {
        
        //init vars
        int k=0, n=0;
        double dist, tmpDist;
        Cluster a, b, b1, b2;
        List<Cluster> clust = new ArrayList(data.size());
        double[][] m = new double[data.size()][data.size()];
        int mSize = m.length;
        //init cluster list
        for (DataPoint p : data) {
            clust.add(new Cluster(new DataPoint[]{p}));
        }
        //init distance matrix
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
                m[i][j] = distFunc.getDistance(clust.get(i), clust.get(j));
            }
        }
        //main loop
        while(mSize > 1){
            b1 = clust.get(0);
            b2 = clust.get(1);
            dist = distFunc.getDistance(b1, b2);
            
            for(k = 0; k < m.length; k++){
                for(n = 0; n < m.length; n++){
                    if(k == n){
                        continue;
                    }
                    a = clust.get(k);
                    b = clust.get(n);
                    tmpDist = distFunc.getDistance(a, b);
                    if(tmpDist < dist){
                        dist = tmpDist;
                        b1 = a;
                        b2 = b;
                    }
                }
            }
            
            clust.set(k, new Cluster(b1, b2));
            clust.remove(n);
            
            for(int i = 0; i < m.length; i++){
                m[][]
            }
            
            mSize--;
        }
        return clust.get(0);
    }
}
