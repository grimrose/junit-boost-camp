package chapter9

import org.junit.Ignore
import org.junit.Rule
import org.junit.Test
import org.junit.experimental.runners.Enclosed
import org.junit.rules.TemporaryFolder
import org.junit.runner.RunWith

import static org.hamcrest.CoreMatchers.*

import static org.junit.Assert.assertThat

@RunWith(Enclosed)
class TemporaryFolderExampleTest {


    public static class _リスト9_4のテスト {
        @Rule
        public TemporaryFolder temporaryFolder = new TemporaryFolder()

        @Test
        void "mkDefaultFilesで２つのファイルが作成される"() {
            // Setup
            File folder = temporaryFolder.root

            // Exercise
            TemporaryFolderExample.mkDefaultFiles(folder)
            def actualFiles = folder.list()
            Arrays.sort(actualFiles)

            // Verify
            assertThat actualFiles.size(), is(2)
            assertThat actualFiles[0], is("UnitTest")
            assertThat actualFiles[1], is("readme.txt")
        }
    }

    public static class _リスト9_6のテスト {
        @Rule
        public SpecificTemporaryFolder temporaryFolder = new SpecificTemporaryFolder()

        @Test
        void "mkDefaultFilesで２つのファイルが作成される"() {
            // Setup
            File folder = temporaryFolder.root

            // Exercise
            TemporaryFolderExample.mkDefaultFiles(folder)
            def actualFiles = folder.list()
            Arrays.sort(actualFiles)

            // Verify
            assertThat actualFiles.size(), is(4)
            assertThat actualFiles[0], is("UnitTest")
            assertThat actualFiles[1], is("readme.txt")
        }
    }


    @Ignore
    static class TemporaryFolderExample {

        static void mkDefaultFiles(File folder) {
            new File(folder, "UnitTest").createNewFile()
            new File(folder, "readme.txt").createNewFile()
        }
    }

}
