library identifier: 'INSSSharedLib', changelog: false

def playprefix = 'UKC'
def channel = '#operations'

def project = 'inss'

def initmap = [
    [projectname: project,
    ChangeLogFile: 'job_change_log.log',
    ChangeLogs: CollectChangeLogs()],
]

def gitmap = [
    [name: 'Repository', url: 'git@github.com:jameswarreninss/myrepotocheckout.git', poll: true, credentials: ''],
]

node('master') {
    cleanWs()
    //StageLinearInOne ('BuildInitialise',initialisemap)
    StageLinearInOne ('ScmCheckout',gitmap)
    StageLinearInOne ('BuildInitialise',initialisemap)
}
