package it.senseisrl.mitiga.survey;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import net.sf.json.JSONObject;

@SuppressWarnings("unused")
public class ApplicationTest {

//	@Test
//	public void testBean() {
//		Country country = new Country();
//		JSONObject jsonObject = JSONObject.fromObject(country);
//		assertEquals(jsonObject.getString("id"), "0");
//	}
//
//	@Test
//	public void testAverageMethod() {
//		long average = Application.averageProbability();
//		assertNotEquals("Should not be 0 ", 0l, average);
//		assertNotEquals(-1, average);
//	}
//
//	@Test
//	public void testCheckMitigationValues() {
//
//		for (Double x : Application.checkMitigationValues()) {
//			assertTrue("Should be greater than 0 , -> " + x, x > 0.00);
//			assertTrue("Should be lower than 1 " + x, x < 1);
//			
//		}
//
//		assertTrue("Array should not be empty", Application.checkMitigationValues().size() > 0);
//
//	}
//
//	@Test
//	public void testJsonModel() {
//
//		List<String> possibleAsset = Arrays.asList("LL3 - LEASE FINANCE 3", "xxxx", "yyyy");
//		List<String> possibleAssetType = Arrays.asList("Software","Hardware");
//
//			assertNotEquals("", null, JsonModel.getJsonDetails());// black box?
//			assertTrue("Not a compatible asset name", possibleAsset.contains(JsonModel.getJsonDetails().getAssetName()));
//			assertTrue("Not a correct asset type", possibleAssetType.contains(JsonModel.getJsonDetails().getAssetTypeName()));
//			assertFalse("Should not be empty", JsonModel.getJsonDetails().getValueList().size() == 0);
//
//	}

}