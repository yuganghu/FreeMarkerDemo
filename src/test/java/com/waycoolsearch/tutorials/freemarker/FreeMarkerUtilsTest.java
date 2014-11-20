package com.waycoolsearch.tutorials.freemarker;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.Assert;

import org.apache.log4j.Logger;
import org.junit.Test;

public class FreeMarkerUtilsTest {

	private static final Logger log = Logger
			.getLogger(FreeMarkerUtilsTest.class);

	@Test
	public void testGenerateList() throws Exception {
		Map<String, Object> root = new HashMap<String, Object>();
		List<String> list = Arrays.asList("JAXB", "JAXP", "Flex", "FreeMarker",
				"Annotation", "Hibernate");
		root.put("values", list);
		String output = FreeMarkerUtils.applyTemplate(
				"src/test/templates/list.ftl", root);
		log.info(output);
		for (String value : list){
			Assert.assertTrue(output.contains(value));
		}
	}

	@Test
	public void testIncludeOutput() throws Exception {
		Map<String, Object> root = new HashMap<String, Object>();
		root.put("title", "FreeMarker tutorials");
		root.put("welcome", "Welcome to FreeMarker tutorials!");
		Map<String, String> tutorial = new HashMap<String, String>();
		root.put("tutorial", tutorial);
		tutorial.put("url", "http://tutorials.waycoolsearch.com/java/");
		tutorial.put("name", "java tutorial");

		List<String> list = Arrays.asList("JAXB", "JAXP", "Flex", "FreeMarker",
				"Annotation", "Hibernate");
		root.put("values", list);

		String output1 = FreeMarkerUtils.applyTemplate(
				"src/test/templates/test.ftl", root);
		String output2 = FreeMarkerUtils.applyTemplate(
				"src/test/templates/list.ftl", root);
		log.info(output1);
		Assert.assertTrue(output1.contains(output2));
	}

}
