i mport FlowJobBuilder

def oahMaster= new FlowJobBuilder(
        name: 'GeneratedFlowJob',
        description: 'this our first stab at it',
        jobs:['job1', 'job2']
).build(this);

oahMaster.with{
  logRotator{
      numToKeep(365)
  }

}

