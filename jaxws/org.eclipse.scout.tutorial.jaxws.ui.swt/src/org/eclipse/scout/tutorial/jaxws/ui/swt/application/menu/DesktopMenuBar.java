/*******************************************************************************
 * Copyright (c) 2010 BSI Business Systems Integration AG.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     BSI Business Systems Integration AG - initial API and implementation
 ******************************************************************************/
package org.eclipse.scout.tutorial.jaxws.ui.swt.application.menu;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.action.IContributionItem;
import org.eclipse.scout.rt.client.ui.action.menu.IMenu;
import org.eclipse.scout.rt.client.ui.action.menu.MenuUtility;
import org.eclipse.scout.rt.ui.swt.ISwtEnvironment;
import org.eclipse.scout.rt.ui.swt.action.menu.SwtScoutMenuContributionItem;
import org.eclipse.scout.tutorial.jaxws.ui.swt.Activator;
import org.eclipse.ui.actions.CompoundContributionItem;

public class DesktopMenuBar extends CompoundContributionItem {

  @Override
  protected IContributionItem[] getContributionItems() {
    ISwtEnvironment env = Activator.getDefault().getEnvironment();
    if (env != null && env.isInitialized()) {
      if (env.getClientSession() != null && env.getClientSession().getDesktop() != null) {
        List<IMenu> menus = env.getClientSession().getDesktop().getMenus();
        List<IMenu> consolidatedMenus = MenuUtility.consolidateMenus(menus);
        List<IContributionItem> swtContributionItems = new ArrayList<IContributionItem>();
        for (IMenu menu : consolidatedMenus) {
          swtContributionItems.add(new SwtScoutMenuContributionItem(menu, env));
        }
        return swtContributionItems.toArray(new IContributionItem[swtContributionItems.size()]);
      }
    }
    return new IContributionItem[0];
  }
}
