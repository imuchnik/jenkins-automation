import FlowJobBuilder

new FlowJobBuilder(
        name: 'sample flow job',
        description: 'this our first stab at it',
        jobs:['job1', 'job2']
).build(this);
