/*******************************************************************************
 * Copyright (c) 2013 BSI Business Systems Integration AG.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     BSI Business Systems Integration AG - initial API and implementation
 ******************************************************************************/
package org.eclipsescout.demo.minicrm.shared.ui.desktop.form;

import org.eclipse.scout.commons.exception.ProcessingException;
import org.eclipse.scout.rt.platform.service.IService;
import org.eclipse.scout.rt.shared.TunnelToServer;
import org.eclipse.scout.rt.shared.validate.IValidationStrategy;
import org.eclipse.scout.rt.shared.validate.InputValidation;

@InputValidation(IValidationStrategy.PROCESS.class)
@TunnelToServer
public interface ICompanyService extends IService {

  CompanyFormData create(CompanyFormData formData) throws ProcessingException;

  CompanyFormData load(CompanyFormData formData) throws ProcessingException;

  CompanyFormData prepareCreate(CompanyFormData formData) throws ProcessingException;

  CompanyFormData store(CompanyFormData formData) throws ProcessingException;

  void delete(Long companyNr) throws ProcessingException;
}
