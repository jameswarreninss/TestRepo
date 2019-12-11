library identifier: 'INSSSharedLib', changelog: false

def playprefix = 'UKC'
def channel = '#operations'

def project = 'inss'

def initialisemap = [[ChangeLogFile: 'job_change_log.log'],]

def gitmap = [
    [name: 'Repository', url: 'git@github.com:jameswarreninss/myrepotocheckout.git', poll: true, credentials: ''],
]

node('master') {
    cleanWs()
    //StageLinearInOne ('BuildInitialise',initialisemap)
    StageLinearInOne ('ScmCheckout',gitmap)
    StageLinearInOne ('BuildInitialise2',initialisemap)
}
