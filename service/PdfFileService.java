package com.demo.SalaryInfoApi.service;

import java.io.FileNotFoundException;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.demo.SalaryInfoApi.dao.CustomerRepository;
import com.demo.SalaryInfoApi.model.Customer;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

@Service
public class PdfFileService {
   
//	@Autowired
//	private CustomerRepository custRepo;
	
	public void pdfCreation()
	{
		String filepath="C:\\Users\\user\\Desktop\\SpringBootPDF\\demo.pdf";
		
		try {
			PdfWriter writer=new PdfWriter(filepath);
			
			PdfDocument pdfdoc=new PdfDocument(writer);
			pdfdoc.addNewPage();
			
			Document document=new Document(pdfdoc);
			document.add(new Paragraph("Example"));
			document.close();
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void pdfGenerate(Customer customer) {
		String filepath="C:\\Users\\user\\Desktop\\SpringBootPDF\\Customer.pdf";
		
		try {
			PdfWriter writer=new PdfWriter(filepath);
			
			PdfDocument pdfdoc=new PdfDocument(writer);
			pdfdoc.addNewPage();
			System.out.println("Is Append mode"+pdfdoc.isAppendMode());
			Document document=new Document(pdfdoc);
			document.add(new Paragraph("Customer Id = "  +
					String.valueOf(customer.getCustId()) +
					"     Customer Name = " +
					customer.getCustName() +
					"     Customer Salary = " +
					String.valueOf(customer.getSalary()) +
					"     Customer Interest = " +
					String.valueOf(customer.getInterest())+
					"  The total amount Customer get from interest is : " +
					(customer.getSalary()*customer.getInterest())/100
					                   )
					    );
			document.close();
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	
	
}
