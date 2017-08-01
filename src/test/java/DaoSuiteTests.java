import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import dao.AcaoDaoTest;
import dao.AreaDaoTest;
import dao.AtividadeDaoTest;
import dao.FuncaoDaoTest;
import dao.GrupoDaoTest;
import dao.LocalTramitacaoDaoTest;
import dao.ProcedimentoDaoTest;
import dao.SubAreaDaoTest;

@RunWith(Suite.class)
@SuiteClasses({ AcaoDaoTest.class, AreaDaoTest.class, AtividadeDaoTest.class, FuncaoDaoTest.class, GrupoDaoTest.class,
		LocalTramitacaoDaoTest.class, ProcedimentoDaoTest.class, SubAreaDaoTest.class })
public class DaoSuiteTests {

}
