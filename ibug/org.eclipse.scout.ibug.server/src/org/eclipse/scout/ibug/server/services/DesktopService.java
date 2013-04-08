package org.eclipse.scout.ibug.server.services;

import java.util.List;

import org.eclipse.scout.commons.exception.ProcessingException;
import org.eclipse.scout.commons.logger.IScoutLogger;
import org.eclipse.scout.commons.logger.ScoutLogManager;
import org.eclipse.scout.ibug.BugzillaHtmlFetcher;
import org.eclipse.scout.ibug.IBug;
import org.eclipse.scout.ibug.IBugFetcher;
import org.eclipse.scout.ibug.shared.services.DesktopFormData;
import org.eclipse.scout.ibug.shared.services.IDesktopService;
import org.eclipse.scout.service.AbstractService;

public class DesktopService extends AbstractService implements IDesktopService {

  private static final IScoutLogger LOG = ScoutLogManager.getLogger(DesktopService.class);

  private IBugFetcher m_bugFetcher = null;

  public DesktopService() {
    super();
    m_bugFetcher = new BugzillaHtmlFetcher();
  }

  public String getCriteria() {
    return m_bugFetcher.getQueryCriteria();
  }

  public int getMaxNumberOfBugs() {
    return m_bugFetcher.getMaxNumberOfBugs();
  }

  public String getAssignee() {
    return m_bugFetcher.getAssignee();
  }

  public void setCriteria(String criteria) {
    m_bugFetcher.setQueryCriteria(criteria);
  }

  public void setMaxNumberOfBugs(int bugs) {
    m_bugFetcher.setMaxNumberOfBugs(bugs);
  }

  public void setAssignee(String assignee) {
    m_bugFetcher.setAssignee(assignee);
  }

  @Override
  public DesktopFormData load(DesktopFormData formData) throws ProcessingException {

    setAssignee(formData.getAssignee().getValue());

    formData.getBugs().clearRows();
    List<IBug> bugs = m_bugFetcher.fetchBugs();

    for (IBug bug : bugs) {
      LOG.info("adding bug " + bug);

      formData.getBugs().addRow(new Object[]{
          bug.getId(),
          bug.getSummary(),
          bug.getChanged(),
          bug.getSeverety(),
          bug.getPriority(),
          bug.getTargetMilestone(),
          bug.getStatus(),
          bug.getResolution(),
          bug.getComponent(),
          bug.getAssignee(),
          bug.getSortValue()
      });
    }

    return formData;
  }
}
