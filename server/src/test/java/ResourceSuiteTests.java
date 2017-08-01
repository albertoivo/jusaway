
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import resource.AcaoResourceTest;
import resource.AreaResourceTest;
import resource.AtividadeResourceTest;
import resource.FuncaoResourceTest;
import resource.GrupoResourceTest;
import resource.LocalTramitacaoResourceTest;
import resource.ProcedimentoResourceTest;
import resource.SubAreaResourceTest;

@RunWith(Suite.class)
@SuiteClasses({ AcaoResourceTest.class, AreaResourceTest.class, AtividadeResourceTest.class, FuncaoResourceTest.class,
		GrupoResourceTest.class, LocalTramitacaoResourceTest.class, ProcedimentoResourceTest.class,
		SubAreaResourceTest.class })
public class ResourceSuiteTests {

}
