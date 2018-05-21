package com.exp.service.impl;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exp.dao.RouteDao;
import com.exp.model.Route;

import com.exp.service.RouteService;

@Service
public class RouteImpl implements RouteService {
	@Autowired
	private RouteDao routeDao;
	
	
	

	
	
	public String[][]getAllroute() {
		// TODO Auto-generated method stub
		 List<Route> routes = routeDao.findAll();
		 int count = 0;
		 for(int i=0;i<routes.size();i++) {
			 count=count+routes.get(i).getEdges().size();
		 }
		 String[][]content = new String[count][3];
//		 int edge=routes.get(0).getEdges().size();
		 int j=0;
		 for(int i=0;i<routes.size();i++) {
			 int edge = routes.get(i).getEdges().size();
			 int start = routes.get(i).getId();
			 String startVertex=Integer.toString(start);
			 if(edge!=0) {
				 for(int k=0;k<edge;k++) {
					 String endVertex  = Integer.toString(routes.get(i).getEdges().get(k).getEndName());
					 System.out.println(endVertex);
					 String distance =  Integer.toString(routes.get(i).getEdges().get(k).getDistance());
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
