package com.exp.model;

public class Vertex implements Comparable<Vertex>{
	private String name;//顶点名称
	private int path;//顶点最短路径长度
	private boolean isMarked;
	
    
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPath() {
		return path;
	}

	public void setPath(int path) {
		this.path = path;
	}

	public boolean isMarked() {
		return isMarked;
	}

	public Vertex(String name){
        this.name = name;
        this.path = Integer.MAX_VALUE; //初始设置为无穷大
        this.setMarked(false);//节点是否已经处理完
    }
    
    public void setMarked(boolean isMarked) {
		// TODO Auto-generated method stub
		this.isMarked= isMarked;
	}

	public Vertex(String name, int path){
        this.name = name;
        this.path = path;
        this.setMarked(false);
    }
    

	@Override
	public int compareTo(Vertex o) {
		// TODO Auto-generated method stub
		return o.path > path?-1:1;
	}
	
}
