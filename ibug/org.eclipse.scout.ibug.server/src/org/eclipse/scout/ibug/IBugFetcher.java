/**
 * 
 */
package org.eclipse.scout.ibug;

import java.util.List;

import org.eclipse.scout.commons.exception.ProcessingException;

/**
 * @author mzi
 */
public interface IBugFetcher {
  public void setQueryCriteria(String criteria);

  public void setMaxNumberOfBugs(int bugs);

  public void setAssignee(String assignee);

  public String getQueryCriteria();

  public int getMaxNumberOfBugs();

  public String getAssignee();

  public List<IBug> fetchBugs() throws ProcessingException;
}
