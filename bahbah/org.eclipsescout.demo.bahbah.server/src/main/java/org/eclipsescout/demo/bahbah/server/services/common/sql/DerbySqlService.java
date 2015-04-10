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
package org.eclipsescout.demo.bahbah.server.services.common.sql;

import org.eclipse.scout.rt.platform.service.IService;
import org.eclipse.scout.rt.server.Server;
import org.eclipse.scout.rt.services.common.jdbc.AbstractDerbySqlService;
import org.eclipsescout.demo.bahbah.server.ServerSession;

@Server(ServerSession.class) /* XXX mvi check requirement of session class */
public class DerbySqlService extends AbstractDerbySqlService implements IService {
}
