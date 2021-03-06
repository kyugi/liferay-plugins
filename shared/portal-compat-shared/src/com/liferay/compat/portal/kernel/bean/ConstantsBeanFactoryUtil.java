/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.compat.portal.kernel.bean;

import com.liferay.portal.kernel.util.PortalClassLoaderUtil;

import java.lang.reflect.Method;

/**
 * @author Brian Wing Shun Chan
 */
public class ConstantsBeanFactoryUtil {

	public static Object getConstantsBean(Class<?> constantsClass) {
		try {
			ClassLoader classLoader = PortalClassLoaderUtil.getClassLoader();

			Class<?> clazz = classLoader.loadClass(
				"com.liferay.portal.kernel.util.ConstantsBeanFactoryUtil");

			Method getConstantsBeanMethod = clazz.getMethod(
				"getConstantsBean", Class.class);

			return getConstantsBeanMethod.invoke(null, constantsClass);
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}