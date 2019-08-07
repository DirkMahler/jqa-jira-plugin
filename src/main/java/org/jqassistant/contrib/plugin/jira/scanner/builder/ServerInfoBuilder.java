package org.jqassistant.contrib.plugin.jira.scanner.builder;

import com.atlassian.jira.rest.client.api.domain.ServerInfo;
import org.jqassistant.contrib.plugin.jira.jjrc.JiraRestClientWrapper;
import org.jqassistant.contrib.plugin.jira.model.JiraServer;

import static org.jqassistant.contrib.plugin.jira.utils.TimeConverter.convertTime;

public class ServerInfoBuilder {

    private final JiraRestClientWrapper jiraRestClientWrapper;

    public ServerInfoBuilder(JiraRestClientWrapper jiraRestClientWrapper) {
        this.jiraRestClientWrapper = jiraRestClientWrapper;
    }

    public void handleServerInfo(JiraServer jiraServer) {

        ServerInfo serverInfo = jiraRestClientWrapper.retrieveServerInfo();
        jiraServer.setBaseUri(serverInfo.getBaseUri()
                .toString());
        jiraServer.setVersion(serverInfo.getVersion());
        jiraServer.setBuildNumber(serverInfo.getBuildNumber());
        jiraServer.setBuildDate(convertTime(serverInfo.getBuildDate()));
        jiraServer.setServerTime(convertTime(serverInfo.getServerTime()));
        jiraServer.setScmInfo(serverInfo.getScmInfo());
        jiraServer.setServerTitle(serverInfo.getServerTitle());
    }
}
