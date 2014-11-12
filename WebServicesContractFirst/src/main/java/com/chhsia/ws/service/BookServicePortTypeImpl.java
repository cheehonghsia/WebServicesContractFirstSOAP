package com.chhsia.ws.service;

import java.util.GregorianCalendar;

import javax.jws.WebService;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;

import com.hascode.tutorial.ws.service.BookServicePortType;
import com.hascode.tutorial.ws.service.BookServiceRequestType;
import com.hascode.tutorial.ws.service.BookServiceResponseType;
import com.hascode.tutorial.ws.service.BookType;

@WebService(endpointInterface = "com.hascode.tutorial.ws.service.BookServicePortType")		
public class BookServicePortTypeImpl implements BookServicePortType {

	@Override
	public BookServiceResponseType fetchBooks(BookServiceRequestType bookServiceRequest) {
		final BookServiceResponseType response = new BookServiceResponseType();
		for (int i = 0; i < bookServiceRequest.getLimit(); i++) {
			final BookType book = new BookType();
			book.setAuthor("Elvis " + i);
			try {
				book.setPublished(DatatypeFactory.newInstance().newXMLGregorianCalendar(new GregorianCalendar(2011, 8, 14)));
			} catch (DatatypeConfigurationException e) {
			}
			book.setTitle("Programming Java Edition #" + i);
			response.getBook().add(book);
		}
		return response;
	}
}