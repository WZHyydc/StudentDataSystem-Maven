package com.finalTest.studentsystem.model;

import com.finalTest.studentsystem.bean.AnalyzeResult;
import com.finalTest.studentsystem.bean.Student;
import com.finalTest.studentsystem.dao.ManageHelper;

import java.util.HashMap;
import java.util.Vector;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class ScoreAnalyzeModel extends AbstractTableModel{
	private ManageHelper helper;
	private Vector<Student> students;
	private  Vector<String> columnNames = null;
	private Vector<Vector<String>> rowData = null;
	
		
	 public ScoreAnalyzeModel(String major_Name,String grade,String classe) {
		helper = new ManageHelper();
		Vector<String> courses = helper.getCourse(helper.getAllMajor().get(major_Name),grade);
		Vector<AnalyzeResult> results = helper.analyzeScore(major_Name, classe, grade);
		
		columnNames = new Vector<String>();
		rowData = new Vector<Vector<String>>();
		columnNames.add("学号");
		columnNames.add("姓名");
		for(int i=0;i<courses.size();i++){
			columnNames.add(courses.get(i));
		}
		columnNames.add("总成绩");
		columnNames.add("平均成绩");
		columnNames.add("排名");
		for(int i=0;i<results.size();i++){
			Vector<String> hang = new Vector<String>();
			AnalyzeResult result = results.get(i);
			hang.add(result.getStudentId());
			hang.add(result.getStudentName());
			HashMap<String, String> scores = helper.getStudentScore(result.getStudentId());
			for(int j=0;j<scores.size();j++){
				String score = scores.get(courses.get(j));
				hang.add(score);
			}
			hang.add(result.getSumScore());
			String avg = result.getAvgScore();
			hang.add(avg.charAt(0)+""+avg.charAt(1)+""+avg.charAt(2)+""+avg.charAt(3));
			hang.add(getRowCount()+1+"");
			rowData.add(hang);
		}
	
		
	}
	

		@Override
		public int getRowCount() {
			// TODO Auto-generated method stub
			return this.rowData.size();
		}

		@Override
		public int getColumnCount() {
			// TODO Auto-generated method stub
			return this.columnNames.size();
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			// TODO Auto-generated method stub
			return ((Vector)this.rowData.get(rowIndex)).get(columnIndex);
		}

		@Override  
		public String getColumnName(int column) {
			// TODO Auto-generated method stub
			return (String)this.columnNames.get(column);
		}
}
