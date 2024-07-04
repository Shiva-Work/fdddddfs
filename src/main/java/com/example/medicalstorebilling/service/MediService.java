package com.example.medicalstorebilling.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.medicalstorebilling.entity.Medicine;
import com.example.medicalstorebilling.repository.MedicineRepo;

@Service
public class MediService {
	
	@Autowired
	private MedicineRepo mRepo;
	
	public List<Medicine> m1()
	{
		List<Medicine> m= mRepo.findAll();
//		for(Medicine m2 : m)
//		{
//			System.out.println(m2);
//		}
		return m; 	
	}
	
	public String m2(Medicine med)
	{
		System.out.println("=========================================================");
		List<Medicine> lisName=mRepo.findByMName(med.getmName());
		System.out.println(lisName);
		
	
		if(lisName.isEmpty())
		{
			mRepo.save(med);
			return"successfully inserted";
		}
		else
		{
			int k=mRepo.findQuantityByMName(med.getmName());
			System.out.println(k);
			int i=k+med.getQuantity();
			med.setQuantity(i);
			//mRepo.save(med);
			mRepo.saveData(i, med.getmName());
			return " already presented Quantity Updated ";
		}
	}

}
