/**************************************************************************
 * copyright file="ICustomXmlSerialization.java" company="Microsoft"
 *     Copyright (c) Microsoft Corporation.  All rights reserved.
 * 
 * Defines the ICustomXmlSerialization.java.
 **************************************************************************/
package com.microsoft.exchange.webservices.data;

import com.porkosoftware.ews.xml.stream.XMLStreamWriter;

/**
 * The Interface CustomXmlSerializationInterface.
 */
 interface ICustomXmlSerialization {

	/**
	 * Custom xml serialization.
	 * 
	 * @param writer
	 *            the writer
	 */
	void CustomXmlSerialization(XMLStreamWriter writer);

}
