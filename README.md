# ews-java-api-android
EWS Java Client For Android

This is a simple packaging of the EWS Java API for Outlook but meant to run on Android.  If you are interested please read here:
(problems-using-the-ews-java-api-on-android)[http://stackoverflow.com/questions/9203073/problems-using-the-ews-java-api-on-android]

This project is built into an Android library project that includes and updated gradle build for it to be easily imported into your project.

## Example
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
