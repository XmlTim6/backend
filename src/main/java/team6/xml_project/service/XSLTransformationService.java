package team6.xml_project.service;

import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

public interface XSLTransformationService {

    String addMetadataToPaper(String paper, String paperLocation) throws IOException, SAXException;

    OutputStream mergeReviews(String review, String transformation, List<String> otherFiles) throws IOException, SAXException;

    OutputStream createPdf(String document, String transformation) throws IOException, SAXException;

    OutputStream createHtml(String document, String transformation) throws  IOException, SAXException;

    OutputStream createXml(String document, String transformation) throws IOException, SAXException;

    OutputStream preprocessPaper(String document, String dateFor) throws IOException, SAXException;
}
