package cambridge;

import cambridge.model.Fragment;
import cambridge.model.FragmentList;
import cambridge.model.TemplateDocument;
import cambridge.runtime.TemplateProperties;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * User: erdinc
 * Date: Nov 6, 2009
 * Time: 2:07:51 PM
 */
public class FragmentSelectorTest {
   @Test
   public void testSelect() {
      final DirectoryTemplateLoader loader = new DirectoryTemplateLoader(new File("."));
      try {
         loader.newTemplateFactory("a.html", new TemplateModifier() {
            @Override
            public void modifyTemplate(TemplateDocument doc) {
               try {
                  FragmentList fragmentList = doc.select("except #s");

                  for (Fragment f : fragmentList) {
                     f.eval(new TemplateProperties(), System.out);
                  }

               } catch (BehaviorInstantiationException e) {
                  e.printStackTrace();
               } catch (IOException e) {
                  e.printStackTrace();
               } catch (TemplateRuntimeException e) {
                  e.printStackTrace();
               }
            }
         });
      } catch (TemplateLoadingException e) {
         e.printStackTrace();
      }
   }
}