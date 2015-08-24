job("running_python_with_docker") {
  scm {
    git {
      remote {
        url ("https://github.com/cgoldberg/python-unittest-tutorial.git")
        branch('origin', 'master')
      }
    }
  }
  triggers {
    scm 'H/5 * * * *'
  }
  steps {
    shell 'docker pull python:latest'
    shell 'docker run -v $WORKSPACE/:/python -w /python python python test_simple.py'
  }
}

