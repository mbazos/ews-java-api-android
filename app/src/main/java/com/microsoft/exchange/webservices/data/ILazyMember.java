/**************************************************************************
 * copyright file="ILazyMember.java" company="Microsoft"
 *     Copyright (c) Microsoft Corporation.  All rights reserved.
 * 
 * Defines the ILazyMember.java.
 **************************************************************************/
package com.microsoft.exchange.webservices.data;

/**
 * The Interface ILazyMember.
 * 
 * @param <T>
 *            the generic type
 */
 abstract interface ILazyMember<T> {

	/**
	 * Creates the instance.
	 * 
	 * @return the t
	 */
    T createInstance();
}
