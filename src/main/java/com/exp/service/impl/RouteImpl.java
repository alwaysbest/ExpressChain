package com.exp.service.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exp.dao.RouteDao;
import com.exp.model.Edge;
import com.exp.model.Route;
import com.exp.model.WarehouseInfo;
import com.exp.service.RouteService;
import com.exp.service.WareService;

@Service
public class RouteImpl implements RouteService {
	@Autowired
	WareService wareService;
	@Autowired
	private RouteDao routeDao;
	@Override
	public String getShortestRoute( int start,int end) {
		
		int[][]arr=getAllroute();
		Set<Integer> pointSet = new HashSet<Integer>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length - 1; j++) {
                if (!pointSet.contains(arr[i][j])) {
                    pointSet.add(arr[i][j]);
                    System.out.println("add " + arr[i][j]);
                }
            }
        }
        System.out.println(pointSet.size());
        int[] pointArr = new int[pointSet.size()];
        int i = 0;
        Map<Integer, Integer> pointMap = new HashMap<Integer, Integer>();
        for (Integer t : pointSet) {
            pointArr[i] = t;
            pointMap.put(t, i);
            i++;
        }
        int[][] mMatrix = new int[pointArr.length][pointArr.length];
        for (int u = 0; u < mMatrix.length; u++) {
            for (int v = 0; v < mMatrix[0].length; v++) {
                mMatrix[u][v] = Integer.MAX_VALUE;
            }
        }

        for (int u = 0; u < arr.length; u++) {
            int a = pointMap.get(arr[u][0]);
            int b = pointMap.get(arr[u][1]);
            mMatrix[a][b] = arr[u][2];
        }

        RouteUtil graphAlogrithm = new RouteUtil(arr.length, pointArr, mMatrix);
        int[] prev = new int[pointArr.length];
        int[] dist = new int[pointArr.length];
       return graphAlogrithm.dijkstra(pointMap.get(start), prev, dist,end);
		
	}
	

	
	@Override
	public int[][]getAllroute() {
		// TODO Auto-generated method stub
		 List<Route> routes = routeDao.findAll();
		 WarehouseInfo warehouseInfo1=wareService.getWarehouseInfoById(2001);
		 WarehouseInfo warehouseInfo2=wareService.getWarehouseInfoById(2002);
		 int wareStore1=warehouseInfo1.getStorage();
		 int wareStore2=warehouseInfo2.getStorage();
		 if(wareStore1==0) {
			 Iterator<Route> rouIter= routes.iterator();
			 while(rouIter.hasNext()) {
				 Route route=rouIter.next();
				 if(route.getId()==2001) {
					 rouIter.remove();
				 }else {
					 Iterator<Edge> edgIter = route.getEdges().iterator();
					 while(edgIter.hasNext()) {
						 Edge edge=edgIter.next();
						 if(edge.getEndName()==2001) {
							 edgIter.remove();
						 }
					 }
 				 }
			 }
		 }else if(wareStore2==0) {
			 Iterator<Route> rouIter= routes.iterator();
			 while(rouIter.hasNext()) {
				 Route route=rouIter.next();
				 if(route.getId()==2002) {
					 rouIter.remove();
				 }else {
					 Iterator<Edge> edgIter = route.getEdges().iterator();
					 while(edgIter.hasNext()) {
						 Edge edge=edgIter.next();
						 if(edge.getEndName()==2002) {
							 edgIter.remove();
						 }
					 }
 				 }
			 }
		 }
		 int count = 0;
		 for(int i=0;i<routes.size();i++) {
			 count=count+routes.get(i).getEdges().size();
		 }
		 int[][]content = new int[count][3];
//		 int edge=routes.get(0).getEdges().size();
		 int j=0;
		 for(int i=0;i<routes.size();i++) {
			 int edge = routes.get(i).getEdges().size();
			 int startVertex = routes.get(i).getId();
//			 String startVertex=Integer.toString(start);
			 if(edge!=0) {
				 for(int k=0;k<edge;k++) {
					int endVertex  = routes.get(i).getEdges().get(k).getEndName();
					 System.out.println(endVertex);
					 int distance = routes.get(i).getEdges().get(k).getDistance();
					 System.out.println(distance);
					 content[j][0]=startVertex;
					 content[j][1]=endVertex;
					 content[j][2]=distance;
					 j++;
				 }
			 }
			 
		 }
		 
		 
		 return content;
	}
	
	

}
