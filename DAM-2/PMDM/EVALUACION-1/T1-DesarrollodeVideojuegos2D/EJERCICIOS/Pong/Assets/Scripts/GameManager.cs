using System.Collections;
using System.Collections.Generic;
using TMPro;
using Unity.VisualScripting;
using UnityEngine;
using UnityEngine.SceneManagement;

public class GameManager : MonoBehaviour
{
    private int scoreOne=0, scoreTwo=0;

    [SerializeField]
    private TMP_Text textone, texttwo;

    [SerializeField] private GameObject panelcontrol;

    [SerializeField]
    private GameObject ball;

    [SerializeField]
    private GameObject padels;

    [SerializeField] 
    private GameObject Walls;

    [SerializeField]
    private GameObject panelpause;

    [SerializeField]
    private GameObject panelwin;

    [SerializeField]
    private TMP_Text textwin;

    private bool ispause=false;
    private bool iswin=false;

    // Instancia estática para ser accedida desde cualquier lugar
    public static GameManager instance;

    void Awake()
    {
        // Comprueba si la instancia ya existe
        if (instance == null)
        {
            // Si no, establece la instancia a esta
            instance = this;
        }
        // Si la instancia ya existe y no es esta:
        else if (instance != this)
        {
            // Entonces destruye este objeto. Esto refuerza nuestro patrón Singleton, lo que significa que solo puede haber una instancia de un GameManager.
            Destroy(gameObject);
        }

        // Establece este para no ser destruido cuando se recargue la escena
        DontDestroyOnLoad(gameObject);
    }

    private void Start()
    {
        StartCoroutine(control());
    }

    private void Update()
    {
        if (Input.GetKeyDown(KeyCode.Escape))
        {
            SceneManager.LoadScene("MainMenu");

        }else if (Input.GetKeyDown(KeyCode.Space))
        {
            if (!ispause)
            {
                pauseGame();
            }else
            {
                reanudeGame();
            }

        }else if(Input.GetKeyDown(KeyCode.R))
        {
            if (iswin)
            {
                restartGame();
                iswin = false;
                StartCoroutine(control());
            }
           
        }
    }
    public void ScorePlayerOne()
    {
        if (scoreOne < 3)
        {
            scoreOne++;
            textone.SetText(scoreOne.ToString());

            StartCoroutine(restart());
        }
        else
        {
            iswin = true;
            panelwin.SetActive(true);
            textwin.SetText("PLAYER 1 WIN");
            ball.SetActive(false);
            Walls.SetActive(false);
            padels.SetActive(false);
        }
       
    }
    public void ScorePlayerTwo() 
    {
        if (scoreTwo < 3)
        {
            scoreTwo++;
            texttwo.SetText(scoreTwo.ToString());
            StartCoroutine(restart());
        }
        else
        {
            iswin = true;
            panelwin.SetActive(true);
            textwin.SetText("PLAYER 2 WIN");
            ball.SetActive(false);
            Walls.SetActive(false);
            padels.SetActive(false);

        }


    }

    private void pauseGame()
    {
      
        Time.timeScale = 0;
        panelcontrol.SetActive(true);
        panelpause.SetActive(true);
        ispause = true;
    }

    private void reanudeGame()
    {
        
        Time.timeScale=1;
        panelcontrol.SetActive(false);
        panelpause.SetActive(false);
        ispause = false;
    }

    private void restartGame()
    {
        panelwin.SetActive(false);
        ball.SetActive(true);
        Walls.SetActive(true);
        padels.SetActive(true);
    }
    IEnumerator restart()
    {
        ball.GetComponent<Transform>().SetPositionAndRotation(new Vector3(0, 0, 0), new Quaternion(0, 0, 0, 0));
        ball.GetComponent<Rigidbody2D>().velocity = Vector3.zero;
        yield return new WaitForSeconds(1);
        ball.GetComponent<Ball>().Launch();
        
        
    }
    IEnumerator control()
    {
        ball.GetComponent<Transform>().SetPositionAndRotation(new Vector3(0, 0, 0), new Quaternion(0, 0, 0, 0));

        panelcontrol.SetActive(true);

        scoreOne = 0;
        scoreTwo = 0;

        for (int i = 3; i >=0 ; i--)
        {
            textone.SetText(i.ToString());
            texttwo.SetText(i.ToString());
            yield return new WaitForSeconds(1);

        }

        panelcontrol.SetActive(false);


        ball.GetComponent<Ball>().Launch();
    }
}

