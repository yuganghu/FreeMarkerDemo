package com.waycoolsearch.tutorials.freemarker;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class FreeMarkerUtils {

	/**
	 * private constructor
	 */
	private FreeMarkerUtils(){
	}

	/**
	 * apply FreeMarker template
	 * @param templateFile
	 * @param objectMap
	 * @return
	 * @throws IOException
	 * @throws TemplateException
	 */
	public static String applyTemplate(String templateFile, Object objectMap) throws IOException, TemplateException {

		Configuration cfg = new Configuration();
		cfg.setObjectWrapper(new DefaultObjectWrapper());

		Template temp = cfg.getTemplate(templateFile);
		ByteArrayOutputStream bo = new ByteArrayOutputStream();
		Writer out = new OutputStreamWriter(bo);
		temp.process(objectMap, out);
		out.flush();
		return bo.toString();
	}
}
