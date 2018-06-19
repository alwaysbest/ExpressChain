package com.exp.service.impl;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;




public class RouteUtil {
	
	

	    private int mEdgNum;        // 边的数量
	    private int[] mVexs;       // 顶点集合
	    private int[][] mMatrix;    // 邻接矩阵
	    private static final int INF = Integer.MAX_VALUE;   // 最大值


	    /*
	 * Dijkstra最短路径。
	 * 即，统计图中"顶点vs"到其它各个顶点的最短路径。
	 * 参数说明：
	 *       vs -- 起始顶点(start vertex)。即计算"顶点vs"到其它顶点的最短路径。
	 *     prev -- 前驱顶点数组。即，prev[i]的值是"顶点vs"到"顶点i"的最短路径所经历的全部顶点中，位于"顶点i"之前的那个顶点。
	 *     dist -- 长度数组。即，dist[i]是"顶点vs"到"顶点i"的最短路径的长度。
	 */
	    public String dijkstra(int vs, int[] prev, int[] dist,int end) {
	        // flag[i]=true表示"顶点vs"到"顶点i"的最短路径已成功获取
	        boolean[] flag = new boolean[mVexs.length];
	        Map<Integer, LinkedList<Integer>> map = new HashMap<Integer, LinkedList<Integer>>();
	        // 初始化
	        for (int i = 0; i < mVexs.length; i++) {
	            flag[i] = false;          // 顶点i的最短路径还没获取到。
	            prev[i] = vs;              // 顶点i的前驱顶点为0。
	            dist[i] = mMatrix[vs][i];  // 顶点i的最短路径为"顶点vs"到"顶点i"的权。
	            LinkedList<Integer> pathStack = new LinkedList<Integer>();
	            pathStack.add(i);
	            map.put(i, pathStack);
	        }

	        // 对"顶点vs"自身进行初始化
	        flag[vs] = true;
	        dist[vs] = 0;

	        // 遍历mVexs.length-1次；每次找出一个顶点的最短路径。
	        int k = 0;
	        for (int i = 1; i < mVexs.length; i++) {
	            // 寻找当前最小的路径；
	            // 即，在未获取最短路径的顶点中，找到离vs最近的顶点(k)。
	            int min = INF;
	            for (int j = 0; j < mVexs.length; j++) {
	                if (flag[j] == false && dist[j] < min) {
	                    min = dist[j];
	                    k = j;
	                }
	            }
	            // 标记"顶点k"为已经获取到最短路径
	            flag[k] = true;

	            // 修正当前最短路径和前驱顶点
	            // 即，当已经"顶点k的最短路径"之后，更新"未获取最短路径的顶点的最短路径和前驱顶点"。
	            for (int j = 0; j < mVexs.length; j++) {
	                int tmp = (mMatrix[k][j] == INF ? INF : (min + mMatrix[k][j]));
	                if (flag[j] == false && (tmp < dist[j])) {
	                    dist[j] = tmp;
	                    prev[j] = k;
	                }
	            }
	        }

	        // 打印dijkstra最短路径的结果
	        System.out.printf("dijkstra(%d): \n", mVexs[vs]);
	        
	            List<Integer> path = new ArrayList<Integer>();
	            setPath(path, vs, end, prev);
	            String reString="";
	           
	            
	            	 for (Integer t : path) {
	            		 reString=reString+"-"+Integer.toString(t);
	                     
	                 }
	                 
	                 System.out.println(reString);
	        return reString;
	    }

	    public void setPath(List<Integer> path, int vs, int cur, int[] prev) {
	        if (cur != vs) {
	            for (int i = 0; i < mVexs.length; i++) {
	                if (i == prev[cur]) {
	                    setPath(path, vs, i, prev);
	                    break;
	                }
	            }
	        }
	        path.add(mVexs[cur]);
	    }

	    public RouteUtil(int mEdgNum, int[] mVexs, int[][] mMatrix) {
	        this.mEdgNum = mEdgNum;
	        this.mVexs = mVexs;
	        this.mMatrix = mMatrix;
	    }

	    
	}
