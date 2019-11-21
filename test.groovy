library 'INSSSharedLib'

//Environment we are deploying to
def environment = JobSuffix()[-3..-1].toUpperCase()
//Environment we are running jenkins from
def runEnvironment = GetEnvironment()

def playprefix = 'UKC'
def channel = '#operations'

def project = 'inss'
def previousjob = PreviousJob()

def initmap = [
    [projectname: project,
    ChangeLogFile: 'job_change_log.log',
    ChangeLogs: CollectChangeLogs()],
]

def gitmap = [
    [name: 'Repository', url: 'git@github.com:jameswarreninss/myrepotocheckout.git', poll: true, credentials: ''],
]

node('master') {
    StageLinearInOne ('BuildInitialise',initmap)
    StageLinearInOne ('ScmCheckout',gitmap)
}
