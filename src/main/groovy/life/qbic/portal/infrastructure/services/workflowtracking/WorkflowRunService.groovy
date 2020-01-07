package life.qbic.portal.infrastructure.services.workflowtracking
import life.qbic.portal.domain.listworkflowruns.WorkflowRun

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * An in memory dummy "database" for the example purposes. In a typical Java app
 * this class would be replaced by e.g. EJB or a Spring based service class.
 * <p>
 * In demos/tutorials/examples, get a reference to this service class with
 * {@link WorkflowRunService#getInstance()}.Å
 */
class WorkflowRunService {

    private static WorkflowRunService instance;
    private static final Logger LOGGER = Logger.getLogger(WorkflowRunService.class.getName());

    private final HashMap<String, WorkflowRun> workflowruns = new HashMap<>();

    /**
     * @return a reference to an example facade for WorkflowRun objects.
     */
    public static WorkflowRunService getInstance() {
        if (instance == null) {
            instance = new WorkflowRunService();
            instance.ensureTestData();
        }
        return instance;
    }

    /**
     * @return all available WorkflowRun objects.
     */
    synchronized List<WorkflowRun> findAll() {
        return findAll(null);
    }

    synchronized List<WorkflowRun> findAll(String stringFilter) {
        ArrayList<WorkflowRun> arrayList = new ArrayList<>();
        for (WorkflowRun workflowruns : workflowruns.values()) {
            try {
                    arrayList.add(workflowruns);

            } catch (RuntimeException rn) {
                Logger.getLogger(WorkflowRunService.class.getName()).log(Level.SEVERE, null, rn);
            }
        }
        return arrayList;
    }

    /**
     * Persists or updates WorkflowRun in the system. Also assigns an identifier
     * for new WorkflowRun instances.
     *
     * @param entry
     */
    synchronized void save(WorkflowRun entry) {
        if (entry == null) {
            LOGGER.log(Level.SEVERE,
                    "WorkflowRun is null. Are you sure you have connected your form to the application as described in tutorial chapter 7?");
            return;
        }
        if (entry.getRunName() == null) {
            entry.setRunName("Test");
        }
        workflowruns.put(entry.getRunName(), entry);
    }

    /**
     * Sample data generation
     */
    void ensureTestData() {
        if (findAll().isEmpty()) {
            final String[] names = ["Gabrielle Patel", "Brian Robinson", "Eduardo Haugen",
                    "Koen Johansen", "Alejandro Macdonald", "Angel Karlsson", "Yahir Gustavsson", "Haiden Svensson",
                    "Emily Stewart", "Corinne Davis", "Ryann Davis", "Yurem Jackson", "Kelly Gustavsson",
                    "Eileen Walker", "Katelyn Martin", "Israel Carlsson", "Quinn Hansson", "Makena Smith",
                    "Danielle Watson", "Leland Harris", "Gunner Karlsen", "Jamar Olsson", "Lara Martin",
                    "Ann Andersson", "Remington Andersson", "Rene Carlsson", "Elvis Olsen", "Solomon Olsen",
                    "Jaydan Jackson", "Bernard Nilsen" ];
            Random ra = new Random(System.nanoTime());

            for (String name : names) {
                WorkflowRun r = new WorkflowRun();
                r.setRunName(name);
                r.setCompletedCount(ra.nextInt(10 -0 +1) + 0);
                r.setFailedCount(ra.nextInt(10 -0 +1) + 0);
                r.setRunningCount(ra.nextInt(10 -0 +1) + 0);
                r.setSubmittedCount(ra.nextInt(10 -0 +1) + 0);
                r.setRunningTaskName("TemplateTask");
                r.setStartTime(new Date());
                r.setCurrentRunStatus(WorkflowRunStatus.values()[ra.nextInt(WorkflowRunStatus.values().length)]);
                save(r);
            }
        }
    }

}
