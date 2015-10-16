import javaposse.jobdsl.dsl.DslFactory
import javaposse.jobdsl.dsl.Job

class BaseJobBuilder {
    String name
    String description
    List<String> emails
    Boolean use_versions
    String pollScmSchedule = '@daily'


    Job build(DslFactory factory){
        factory.job(name){
            it.description this.description
            addBaseStuff(delegate,this.emails)

            triggers {
                scm pollScmSchedule
            }
        }
    }


    static void addColorizeOutput(context){

        context.with{
            colorizeOutput()
        }
    }

     static void addBaseStuff(context, emails) {
        context.with{
            wrappers{
                addColorizeOutput(delegate)
            }
            logRotator {
                numToKeep(10)
            }
            publishers{
                mailer emails.join(' ')
            }
        }

    }
}
