package com.ppu.jfast.predisburse1server;

import static org.junit.Assert.assertTrue;

import java.util.List;

import com.ppu.jfast.predisburse1server.controllers.PCPProcessController;
import com.ppu.jfast.predisburse1server.pojo.PCPUploadRow;
import com.ppu.jfast.predisburse1server.repo.IPCPUploadsRepo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class DemoApplicationTests {

	@Autowired
	PCPProcessController controller;

	@Autowired
	IPCPUploadsRepo repo;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testPCPUploadsFindAll() {
		List<?> list = controller.getAll();

		System.out.println(list.size() + " rows");
		Utility.printList(list);

		assertTrue(list.size() > 0);
	}

	@Test
	public void testGetMFByShortName(){
		List<String[]> list = repo.findMFByShortName("RFDTK02");

		System.out.println(list.size() + " rows");
		Utility.printList(list);
		
		assertTrue(list.size() > 0);
	}

	@Test
	public void testGetJoinPCPList(){
		List<PCPUploadRow> list = controller.getPCPProcessList();

		System.out.println(list.size() + " rows");
		Utility.printList(list);
		
		assertTrue(list.size() > 0);
	}

	@Test
	public void testLOVAgreement(){
		List<String[]> list = repo.lovAgreementWithPkg();
		System.out.println(list.size() + " rows");
		Utility.printList(list);
		
		assertTrue(list.size() > 0);
	}

	@Test
	public void tesLOVScheme(){
		List<String[]> list = repo.lovScheme();
		System.out.println(list.size() + " rows");
		Utility.printList(list);
		
		assertTrue(list.size() > 0);
	}


}
