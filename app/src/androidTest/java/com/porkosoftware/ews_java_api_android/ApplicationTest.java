package com.porkosoftware.ews_java_api_android;

import android.app.Application;
import android.test.ApplicationTestCase;

import com.microsoft.exchange.webservices.data.BasePropertySet;
import com.microsoft.exchange.webservices.data.CalendarFolder;
import com.microsoft.exchange.webservices.data.ExchangeCredentials;
import com.microsoft.exchange.webservices.data.ExchangeService;
import com.microsoft.exchange.webservices.data.FindFoldersResults;
import com.microsoft.exchange.webservices.data.Folder;
import com.microsoft.exchange.webservices.data.FolderSchema;
import com.microsoft.exchange.webservices.data.FolderTraversal;
import com.microsoft.exchange.webservices.data.FolderView;
import com.microsoft.exchange.webservices.data.PropertySet;
import com.microsoft.exchange.webservices.data.SearchFilter;
import com.microsoft.exchange.webservices.data.WebCredentials;
import com.microsoft.exchange.webservices.data.WellKnownFolderName;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    private final ExchangeService service = new ExchangeService();

    public ApplicationTest() throws URISyntaxException {
        super(Application.class);
        ExchangeCredentials credentials = new WebCredentials("username", "password", "domain");
        service.setCredentials(credentials);
        service.setUrl(new URI("https://hostname/EWS/Exchange.asmx"));
    }


    public void testFindFolderResults() throws Exception {
        FolderView view = new FolderView(10);
        PropertySet set = new PropertySet(BasePropertySet.IdOnly);
        set.add(FolderSchema.DisplayName);
        view.setPropertySet(set);
        SearchFilter searchFilter = new SearchFilter.IsGreaterThan(FolderSchema.TotalCount, 0);
        view.setTraversal(FolderTraversal.Deep);
        FindFoldersResults findFolderResults = service.findFolders(WellKnownFolderName.Root, searchFilter, view);
        for (Folder folder : findFolderResults) {
            System.out.println("folder: " + folder.getDisplayName());
        }
    }
}