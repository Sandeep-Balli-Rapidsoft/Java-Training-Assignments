package com.QAServiceLayer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import com.QADAO.QADAO;
import com.QAEntity.QualityAnalyst;

public class QAServiceLayer {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void insertNewQAData() throws Exception {
		System.out.println("Enter Quality Analyst Name");
		String qaName = br.readLine();
		System.out.println("Enter Assigned Manager ID");
		Integer managerId = Integer.parseInt(br.readLine());
		
		QADAO.insertQAData(qaName, managerId);
	}
	
	public static void getQualityAnalystById() throws Exception {
		System.out.println("Enter QA Id");
		Integer qualityAnalystId = Integer.parseInt(br.readLine());
		
		QualityAnalyst qualityAnalyst = QADAO.getQualityAnalystById(qualityAnalystId);
		
		System.out.println("Quality Analyst Id: " + qualityAnalyst.getId());
		System.out.println("Quality Analyst Name: " + qualityAnalyst.getQa_name());
		System.out.println("Manager Name: " + qualityAnalyst.getManager().getManager_name());
	}
	
	public static void getAllQualityAnalysts() throws Exception {
		List<QualityAnalyst> qualityAnalystList = QADAO.getAllQualityAnalysts();
		
		for(QualityAnalyst qualityAnalyst : qualityAnalystList) {
			System.out.println("Quality Analyst ID: " + qualityAnalyst.getId() + "\t Quality Analyst Name: " + qualityAnalyst.getQa_name() + " \t Manager Name: " + qualityAnalyst.getManager().getManager_name());
			System.out.println();
		}
	}
}
